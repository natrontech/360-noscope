<script>
  import MunicipalitiesFilter from "$lib/components/data/Municipalities/MunicipalitiesFilter.svelte";
  import MunicipalitiesList from "$lib/components/data/Municipalities/MunicipalitiesList.svelte";
  import Stats from "$lib/components/data/Stats.svelte";
  import SurveysFilter from "$lib/components/data/Surveys/SurveysFilter.svelte";
  import SurveysList from "$lib/components/data/Surveys/SurveysList.svelte";
  import showSurvey from "$lib/stores/toggle";
  import { fly } from "svelte/transition";
</script>

<div class="absolute top-5 right-0 left-0 bottom-5 overflow-hidden">
  <div class="absolute top-0 w-full">
    <Stats />
  </div>

  {#if $showSurvey}
    <div
      class="absolute w-full overflow-y-scoll top-56 bottom-0 left-0 right-0"
      in:fly|global={{ x: 50, duration: 100, delay: 100 }}
      out:fly|global={{ x: 50, duration: 100 }}
    >
      <SurveysFilter />
      <div class="absolute top-10 bottom-0 left-0 right-0 overflow-y-scroll scrollbar-none">
        <SurveysList />
      </div>
    </div>
  {:else}
    <div
      class="absolute w-full overflow-y-scoll top-56 bottom-0 left-0 right-0"
      in:fly|global={{ x: -50, duration: 100, delay: 100 }}
      out:fly|global={{ x: -50, duration: 100 }}
    >
      <MunicipalitiesFilter />
      <div class="absolute top-10 bottom-0 left-0 right-0 overflow-y-scroll scrollbar-none">
        <MunicipalitiesList />
      </div>
    </div>
  {/if}
</div>
