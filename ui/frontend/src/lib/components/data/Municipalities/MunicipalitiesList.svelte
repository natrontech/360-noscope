<script lang="ts">
  import MunicipalitiesListItem from "./MunicipalitiesListItem.svelte";

  // TODO: fetch from backend /api/municipalities
  interface Municipality {
    id: string;
    name: string;
  }



</script>

<ul role="list" class="divide-y divide-gray-100">
  <MunicipalitiesListItem />
</ul>
