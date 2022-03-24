<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      Broadcast View
      <p>{{ textput }}</p>
    </div>
  </q-page>
</template>

<script>
import { Notify } from "quasar";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";

export default {
  setup() {
    const router = useRoute();
    const state = {
      textput: ref(""),
    };
    onMounted(() => {
      state.textput.value = router.params.broadcastvalue;
      Notify.create({
        message: "Broadcast received: " + router.params.broadcastvalue,
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
