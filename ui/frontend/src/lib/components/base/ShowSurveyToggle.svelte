<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { Castle, ClipboardList } from "lucide-svelte";
  import { get } from "svelte/store";

  $: console.log(get(showSurvey));
</script>

<div class="flex justify-between items-center">
  <div class="btn-group">
    <button
      on:click={() => showSurvey.set(false)}
      class="btn
      {$showSurvey ? '' : 'btn-neutral'}"
    >
      <Castle />
      Gemeinden</button
    >
    <button
      on:click={() => showSurvey.set(true)}
      class="btn
    {$showSurvey ? 'btn-neutral' : ''}"
    >
      <ClipboardList />
      Umfragen</button
    >
  </div>
</div>
