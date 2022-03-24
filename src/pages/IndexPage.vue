<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <q-select
        v-model="selected"
        :options="options"
        label="Select any broadcast"
        style="min-width: 300px"
      />
      <q-btn @click="onButtonClick" label="Submit" />
    </div>
  </q-page>
</template>

<script>
import { defineComponent, ref } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "IndexPage",
  setup() {
    const router = useRouter();
    const state = {
      options: [
        "Custom broadcast receiver",
        "Wifi RTT state change receiver",
        "System battery notification receiver",
      ],
      selected: ref("Custom broadcast receiver"),
    };
    return {
      ...state,
      onButtonClick: () => {
        switch (state.selected.value) {
          case state.options[0]:
            router.push("/custombroadcast");
            break;
          case state.options[1]:
            router.push("/wifirtt");
            break;
          case state.options[2]:
            router.push("/batteryreceiver");
            break;
        }
      },
    };
  },
});
</script>
