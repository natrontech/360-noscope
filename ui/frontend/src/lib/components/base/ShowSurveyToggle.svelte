<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { Castle, ClipboardList, Database } from "lucide-svelte";
  import Recommendations from "./Recommendations.svelte";

  let avgScoreSurveyDrift = 1.4;

  // show <Recommendations /> after 10 seconds (10000ms)
  let showRecommendations = false;
  setTimeout(() => {
    showRecommendations = true;
  }, 20000);
</script>

<div class="flex justify-between items-center w-full">
  <div>
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
      >
    </div>
  </div>

  <Recommendations bind:show={showRecommendations} />

  <div>
    <button class="btn">
      <Database />
      Daten Crawler</button
    >
  </div>
</div>
