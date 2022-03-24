<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <p class="text-h6">Battery Broadcast Sender</p>
      <q-input
        v-model="batteryput"
        label="Input battery percentage"
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
import { Notify } from "quasar";
import { ref } from "vue";
import { useRouter } from "vue-router";

export default {
  setup() {
    const router = useRouter();
    const state = {
      batteryput: ref(""),
    };
    return {
      ...state,
      onSubmit: () => {
        if (state.batteryput.value) {
          router.push({
            name: "batteryvalue",
            params: { batteryvalue: state.batteryput.value },
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
