<script lang="ts">
  import type { ParticipatingMunicipality } from "$lib/types/analyze-data";
  import { CircleSlash, CircleSlash2, FileLineChart, LineChart } from "lucide-svelte";
  import RatingLabel from "../RatingLabel.svelte";
    import OneLineDiagram from "../OneLineDiagram.svelte";

  export let participatingMunicipality: ParticipatingMunicipality;

  function numberToFloat(number: number) {
    return number.toFixed(2);
  }

</script>

<li class="flex items-center justify-between gap-x-6 py-5">
  <div class="flex w-full justify-between">
    <div class="min-w-0">
      <div class="flex items-start gap-x-3">
        <p class="text-sm font-semibold leading-6 text-gray-900">
          {participatingMunicipality.name}
        </p>
        <RatingLabel
          quantitativeRating={participatingMunicipality.avgQuantitativeRating}
          qualitativeRating={participatingMunicipality.avgQualitativeRating}
        />
      </div>
      <div class="mt-1 flex items-center gap-x-2 text-xs leading-5 text-gray-500">
        <p class="whitespace-nowrap">
          {participatingMunicipality.region}
        </p>
        <svg viewBox="0 0 2 2" class="h-0.5 w-0.5 fill-current">
          <circle cx="1" cy="1" r="1" />
        </svg>
        <p class="truncate">
          ({participatingMunicipality.canton}, {participatingMunicipality.district})
        </p>
      </div>
    </div>
    <div class="overflow-hidden flex gap-4 border-bet">
      <OneLineDiagram quantitativeRating={participatingMunicipality.avgQuantitativeRating} qualitativeRating={participatingMunicipality.avgQualitativeRating}/>
      <!-- <div
        class="bg-gray-200 p-2 rounded-lg shadow-lg text-3xl font-semibold tracking-tight text-gray-900 flex justify-center content-center items-center gap-2"
      >
        <p class="truncate text-xs font-medium text-gray-500">
          <LineChart class="inline h-5 w-5" />
        </p>
        <p>
          {numberToFloat(participatingMunicipality.avgQuantitativeRating)}
        </p>
      </div>
      <div
        class="bg-gray-200 p-2 rounded-lg shadow-lg text-3xl font-semibold tracking-tight text-gray-900 flex justify-center content-center items-center gap-2"
      >
        <p class="truncate text-xs font-medium text-gray-500">
          <FileLineChart class="inline h-5 w-5" />
        </p>
        <p>
          {numberToFloat(participatingMunicipality.avgQualitativeRating)}
        </p>
      </div>
    </div> -->
  </div>
  <div class="flex flex-none items-center gap-x-4">
    <a
      href="#"
      class="hidden rounded-md bg-white px-2.5 py-1.5 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:block"
      >Details</a
    >
    <div class="relative flex-none">
      <button
        type="button"
        class="-m-2.5 block p-2.5 text-gray-500 hover:text-gray-900"
        id="options-menu-0-button"
        aria-expanded="false"
        aria-haspopup="true"
      >
        <span class="sr-only">Open options</span>
        <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
          <path
            d="M10 3a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM10 8.5a1.5 1.5 0 110 3 1.5 1.5 0 010-3zM11.5 15.5a1.5 1.5 0 10-3 0 1.5 1.5 0 003 0z"
          />
        </svg>
      </button>
    </div>
  </div>
</li>
