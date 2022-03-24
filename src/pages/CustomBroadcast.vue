<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <q-input
        v-model="textput"
        label="Input any text"
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
      textput: ref(""),
    };
    return {
      ...state,
      onButtonClick: () => {
        if (state.textput.value) {
          router.push({
            name: "customvalue",
            params: { broadcastvalue: state.textput.value },
          });
        }
      },
    };
  },
};
</script>
