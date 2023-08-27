<script lang="ts">
  import { Bot } from "lucide-svelte";
  import { fly } from "svelte/transition";
  export let show = false;
</script>

{#if show}
  <div
    class=" animate-wiggle gradient-shadow rounded-lg"
    in:fly={{ y: -50, duration: 300 }}
    out:fly={{ y: -50, duration: 300 }}
  >
    <button class="bg-neutral ring-blue-500 ring-2 p-2 text-white rounded-lg">
      <div class="absolute top-1 right-1/2 translate-x-1/2 font-medium rounded-tr-md text-md px-1">
        <div
          class="bg-gradient-to-r bg-white p-2 text-white absolute rounded-full animate-ping top-0 left-2"
        />
        <Bot size="24" class="inline" />
        Vorschlag</div
      >
      <br />
      Generelle Bilanz verbessern mit Verkauf von <br /> <b>Zürich</b> an Deutschland
    </button>
  </div>
{/if}

<style>
  .gradient-shadow {
    box-shadow: 0px 10px 15px -3px rgba(143, 58, 251, 0.6), 0px 4px 6px -2px rgba(255, 64, 129, 0.6);
  }
</style>
