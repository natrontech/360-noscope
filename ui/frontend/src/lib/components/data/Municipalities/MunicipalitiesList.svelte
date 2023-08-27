<script lang="ts">
  import { apiMunicipalitiesResponse } from "$lib/mock/analyze-data";
  import type { ApiMunicipalitiesResponse } from "$lib/types/analyze-data";
  import MunicipalitiesListItem from "./MunicipalitiesListItem.svelte";

  // TODO: fetch from backend /api/municipalities
  let localApiMunicipalitiesResponse: ApiMunicipalitiesResponse = apiMunicipalitiesResponse;
</script>

<ul role="list" class="divide-y divide-gray-200 divide-y-2">
  {#each localApiMunicipalitiesResponse.municipalities as participatingMunicipality}
    <MunicipalitiesListItem {participatingMunicipality} />
  {/each}
</ul>
