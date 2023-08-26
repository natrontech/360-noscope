<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { Castle, ClipboardList, Database } from "lucide-svelte";
</script>

<div class="flex justify-between items-center w-full">
  <div>
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

  <div>
    <button class="btn">
      <Database />
      Daten Crawler</button
    >
  </div>
</div>
