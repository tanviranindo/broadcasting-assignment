<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p>Wifi Broadcast</p>
    </div>
  </q-page>
</template>

<script>
import { Notify } from "quasar";
import { ref, onMounted } from "vue";
export default {
  setup() {
    const { navigator } = window;
    const state = {
      wifistate: ref(""),
    };

    navigator.connection.onchange = WifiRTTFunction;

    function WifiRTTFunction() {
      state.wifistate.value = navigator.connection.type;
      Notify.create({
        message: "Broadcast received: " + state.wifistate.value,
        actions: [
          {
            label: "Dismiss",
            color: "white",
            handler: () => {},
          },
        ],
      });
    }

    onMounted(WifiRTTFunction);
    return {
      ...state,
    };
  },
};
</script>
