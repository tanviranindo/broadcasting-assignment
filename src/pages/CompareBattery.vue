<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p>{{ batterystatus }}</p>
      <p>{{ systembatterystatus }}%</p>
    </div>
  </q-page>
</template>

<script>
import { Notify } from "quasar";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

export default {
  setup() {
    const { navigator } = window;
    const router = useRoute();
    const state = {
      batterystatus: ref(""),
      systembatterystatus: ref(""),
    };

    onMounted(async () => {
      state.batterystatus.value = router.params.batteryvalue;
      const { level } = await navigator.getBattery();
      state.systembatterystatus.value = level * 100;

      Notify.create({
        message: "Broadcast received: " + router.params.batteryvalue,
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
    };
  },
};
</script>
