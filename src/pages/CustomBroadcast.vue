<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p class="text-h6">Custom Broadcast Sender</p>
      <q-input
        v-model="broadcasttext"
        label="Input any text"
        style="min-width: 300px"
      />
      <q-btn color="purple" @click="onSubmit" label="Submit" />
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
import { ref } from "vue";
import { Notify } from "quasar";
import { useRouter } from "vue-router";

export default {
  setup() {
    const router = useRouter();
    const state = {
      broadcasttext: ref(null),
    };
    return {
      ...state,
      onSubmit: () => {
        if (state.broadcasttext.value) {
          router.push({
            name: "broadcastvalue",
            params: { broadcastvalue: state.broadcasttext.value },
          });
        } else {
          Notify.create({
            message: "Please insert value",
          });
        }
      },
      onReturn: () => {
        router.push("/");
      },
    };
  },
};
</script>
