<script lang="ts">
  import { apiSurveysResponse } from "$lib/mock/analyze-data";
  import type { ApiSurveysResponse } from "$lib/types/analyze-data";
    import SurveysListItem from "./SurveysListItem.svelte";

  // TODO: fetch from backend /api/surveys
  let localApiSurveysResponse: ApiSurveysResponse = apiSurveysResponse;
</script>

<ul role="list" class="divide-y divide-gray-200 divide-y-2">
  {#each localApiSurveysResponse.surveys as survey}
    <SurveysListItem {survey} />
  {/each}
</ul>
