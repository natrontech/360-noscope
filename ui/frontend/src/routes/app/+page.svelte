<script>
  import MunicipalitiesFilter from "$lib/components/data/Municipalities/MunicipalitiesFilter.svelte";
  import MunicipalitiesList from "$lib/components/data/Municipalities/MunicipalitiesList.svelte";
  import Stats from "$lib/components/data/Stats.svelte";
</script>

<Stats />
<div class="mt-10">
  <MunicipalitiesFilter />
  <MunicipalitiesList />
</div>
