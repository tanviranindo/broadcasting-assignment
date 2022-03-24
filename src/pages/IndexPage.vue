<template>
  <q-page class="flex flex-center">
    <div class="column q-gutter-y-md flex-center">
      <q-select
        standout="bg-grey text-black"
        v-model="selected"
        :options="options"
        label="Select broadcast receiver"
        style="min-width: 300px"
      />
      <q-btn color="purple" @click="onButtonClick" label="Submit" />
    </div>
  </q-page>
</template>

<script>
import { Notify } from "quasar";
import { defineComponent, ref } from "vue";
import { useRouter } from "vue-router";

export default defineComponent({
  name: "IndexPage",
  setup() {
    const router = useRouter();
    const state = {
      selected: ref(null),
      options: [
        "Custom broadcast receiver",
        "WIFI RTT state change receiver",
        "System battery notification receiver",
      ],
    };
    return {
      ...state,
      onButtonClick: () => {
        if (state.selected.value) {
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
        } else {
          Notify.create({
            message: "Please select any receiver",
          });
        }
      },
    };
  },
});
</script>
