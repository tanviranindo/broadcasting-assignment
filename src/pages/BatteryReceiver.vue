<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <q-input
        v-model="batteryput"
        label="Input battery percentage"
        style="min-width: 300px"
      />
      <q-btn @click="onButtonClick" label="Submit" />
    </div>
  </q-page>
</template>

<script>
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
      onButtonClick: () => {
        if (state.batteryput.value) {
          router.push({
            name: "batteryvalue",
            params: { batteryvalue: state.batteryput.value },
          });
        }
      },
    };
  },
};
</script>
