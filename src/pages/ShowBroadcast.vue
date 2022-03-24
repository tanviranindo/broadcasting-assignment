<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p class="text-h6">Custom Broadcast Receiver</p>
      <p>{{ broadcasttext }}</p>
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
import { Notify } from "quasar";
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

export default {
  setup() {
    const route = useRoute();
    const router = useRouter();
    const state = {
      broadcasttext: ref(null),
    };
    onMounted(() => {
      state.broadcasttext.value = route.params.broadcastvalue;
      Notify.create({
        message: "Broadcast received: " + route.params.broadcastvalue,
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
      onReturn: () => {
        router.push("/custombroadcast");
      },
    };
  },
};
</script>
