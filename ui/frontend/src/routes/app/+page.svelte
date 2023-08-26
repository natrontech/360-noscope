<script>
  import MunicipalitiesFilter from "$lib/components/data/Municipalities/MunicipalitiesFilter.svelte";
  import MunicipalitiesList from "$lib/components/data/Municipalities/MunicipalitiesList.svelte";
  import Stats from "$lib/components/data/Stats.svelte";
  import showSurvey from "$lib/stores/toggle";
</script>

<div class="absolute top-5 right-5 left-5 bottom-5 overflow-hidden">
  <div class="absolute top-0 w-full">
    <Stats />
  </div>
  <div class="absolute w-full overflow-y-scoll top-56 bottom-0 left-0 right-0">
    {#if $showSurvey}{:else}
      <MunicipalitiesFilter />
    {/if}
    <div class="absolute top-10 bottom-0 left-0 right-0 overflow-y-scroll scrollbar-none">
      {#if $showSurvey}{:else}
        <MunicipalitiesList />
      {/if}
    </div>
  </div>
</div>
