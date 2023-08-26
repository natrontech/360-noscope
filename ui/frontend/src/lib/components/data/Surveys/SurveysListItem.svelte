<script lang="ts">
  import type { ParticipatingSurvey } from "$lib/types/analyze-data";
  import {
    FileLineChart,
    MoveHorizontal
  } from "lucide-svelte";

  export let survey: ParticipatingSurvey;

  console.log(survey);

  function numberToFloat(number: number) {
    return number.toFixed(2);
  }

  function calculateColor() {
    const difference = Math.abs(
      survey.avgQualitativeRating
    );
    if (difference >= 7.5) return "bg-green-500";
    if (difference >= 6.5) return "bg-yellow-500";
    if (difference >= 4.5) return "bg-orange-500";
    return "red";
  }
</script>

<li class="flex items-center justify-between gap-x-6 py-2">
  <div class="flex w-full items-center justify-center">
    <div class="">
      <div class="flex items-start gap-x-3">
        <p class="text-sm font-semibold leading-6 text-neutral">
          {survey.name}
        </p>
        <!-- <RatingLabel
          quantitativeRating={survey.avgQuantitativeRating}
          qualitativeRating={survey.avgQualitativeRating}
        /> -->
      </div>
      <div class="mt-1 flex items-center gap-x-2 text-xs leading-5 text-gray-500">
        <p class="whitespace-nowrap">
          {survey.totalParticipatingMunicipalities}
        </p>
        <svg viewBox="0 0 2 2" class="h-0.5 w-0.5 fill-current">
          <circle cx="1" cy="1" r="1" />
        </svg>
        <p class="truncate">
          teilnehmende Gemeinden
          <!-- ({survey.canton}, {survey.district}) -->
        </p>
      </div>
    </div>
    <div class="w-full flex justify-end pr-10 ">
      <div>
        <div class="relative overflow-hidden rounded-lg bg-white pt-2">
          <div class="flex gap-6">
            <div>
              <dt>
                <div class="absolute rounded-md {calculateColor()} p-3">
                  <div class="h-6 w-6 text-white">
                    <FileLineChart />
                  </div>
                </div>
                <p class="ml-16 truncate text-sm font-medium text-gray-500">Bewertung</p>
              </dt>
              <dd class="ml-16 flex items-baseline">
                <p class="text-2xl font-semibold text-neutral">
                  {numberToFloat(
                    Math.abs(
                      survey.avgQualitativeRating
                    )
                  )}
                </p>
              </dd>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="flex flex-none items-center gap-x-4">
      <a
        href="#"
        class="hidden rounded-md bg-white px-2.5 py-1.5 text-sm font-semibold text-neutral shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:block"
        >Details</a
      >
      <div class="relative flex-none">
        <button
          type="button"
          class="-m-2.5 block p-2.5 text-gray-500 hover:text-neutral"
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
  </div>
</li>
