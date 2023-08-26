<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { Castle, ClipboardList, Database } from "lucide-svelte";
</script>

<<<<<<< HEAD
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
=======
<div class="flex justify-between items-center">
  <div class="btn-group">
    <button
      on:click={() => showSurvey.set(false)}
      class="btn
      {$showSurvey ? 'btn-neutral border-white' : ''}"
    >
      <Castle />
      Gemeinden</button
    >
    <button
      on:click={() => showSurvey.set(true)}
      class="btn
    {$showSurvey ? '' : 'btn-neutral border-white'}"
    >
      <ClipboardList />
      Umfragen</button
>>>>>>> 079ef9d (feat: add gemeinden page)
    >
  </div>
</div>
