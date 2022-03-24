<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p class="text-h6">WIFI RTT Broadcast State</p>
      <p><strong>Connected: </strong>{{ wifistate ? "Yes" : "No" }}</p>
      <p><strong>Connection Type: </strong>{{ conntype }}</p>
      <q-toggle @vnode-updated="onChangeFunction" v-model="togglestate" />
      <q-btn
        color="white"
        text-color="black"
        @click="onReturn"
        label="Return"
      />
    </div>
  </q-page>
</template>

<script>
// import { WifiWizard2 } from "@awesome-cordova-plugins/wifi-wizard-2";
import { Network } from "@capacitor/network";
import { Notify } from "quasar";
import { useRouter } from "vue-router";
import { ref, onMounted } from "vue";
export default {
  setup() {
    // togglestate: ref(false), // inside state
    // state.togglestate.value = WifiWizard2.isWifiEnabled(); // inside RTTfunction

    const router = useRouter();
    const state = {
      togglestate: ref(false),
      conntype: ref(null),
      wifistate: ref(null),
    };

    Network.addListener("networkStatusChange", WifiRTTFunction);

    async function WifiRTTFunction() {
      // state.togglestate.value = WifiWizard2.isWifiEnabled();
      state.wifistate.value = (await Network.getStatus()).connected;
      state.conntype.value = (
        await Network.getStatus()
      ).connectionType.toLocaleUpperCase();

      Notify.create({
        message: state.wifistate.value
          ? "Internet is connected"
          : "Internet is disconnected",
      });
    }

    onMounted(WifiRTTFunction);
    return {
      ...state,
      onChangeFunction: (val) => {
        console.log(state.togglestate.value);
        console.log(val);
        // WifiWizard2.setWifiEnabled(val);
      },
      onReturn: () => {
        router.push("/");
      },
    };
  },
};
</script>
