<script lang="ts">
  import { ArrowDown, ArrowUp } from "lucide-svelte";

  export let difference: number;
</script>

{#if difference > 0}
  <p class="ml-2 flex items-baseline text-sm font-semibold text-green-600">
    <ArrowUp class="h-5 w-5 flex-shrink-0 self-center text-green-500" />
    {Math.abs(difference)}
  </p>
{:else}
  <p class="ml-2 flex items-baseline text-sm font-semibold text-red-600">
    <ArrowDown class="h-5 w-5 flex-shrink-0 self-center text-red-500" />
    {Math.abs(difference)}
  </p>
{/if}
