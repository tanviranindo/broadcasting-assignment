<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p class="text-h6">Battery Broadcast Receiver</p>
      <div>
        <p><strong>User Input: </strong> {{ batterystatus }}%</p>
        <p><strong>Battery Status: </strong> {{ systembatterystatus }}%</p>
        <p><strong>Charging: </strong>{{ chargingstatus ? "Yes" : "No" }}</p>

        <p>
          <strong>Output: </strong>
          {{
            batterystatus == systembatterystatus
              ? "Your prediction is correct"
              : batterystatus < 0 || batterystatus > 100
              ? "Percentage has to be in between 0 to 100"
              : "Your prediction is wrong"
          }}
        </p>
      </div>
      <q-btn
        color="white"
        text-color="black"
        @click="onButtonClick"
        label="Return"
      />
    </div>
  </q-page>
</template>

<script>
import { Notify } from "quasar";
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

export default {
  setup() {
    const { navigator } = window;
    const route = useRoute();
    const router = useRouter();
    const state = {
      batterystatus: ref(null),
      systembatterystatus: ref(null),
      chargingstatus: ref(null),
    };

    onMounted(async () => {
      state.batterystatus.value = route.params.batteryvalue;
      const { level, charging } = await navigator.getBattery();
      state.systembatterystatus.value = level * 100;
      state.chargingstatus.value = charging;

      Notify.create({
        message: "Broadcast received: " + route.params.batteryvalue,
        actions: [
          {
            label: "Dismiss",
            color: "white",
            handler: () => {},
          },
        ],
      });
    });

    return {
      ...state,
      onButtonClick: () => {
        router.push("/batteryreceiver");
      },
    };
  },
};
</script>
