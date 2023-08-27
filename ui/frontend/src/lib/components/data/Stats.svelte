<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { CalendarCheck, Castle, ClipboardList, FileLineChart, LineChart } from "lucide-svelte";
  import InDecrease from "./InDecrease.svelte";
  import type { MunicipalitiesStats, SurveyStats } from "$lib/types/analyze-data";
  import { fly } from "svelte/transition";

  // TODO: fetch from backend /api/municipalities
  let municipalityStats: MunicipalitiesStats = {
    totalMunicipalities: 300,
    avgQuantitativeRating: 6.8,
    avgQualitativeRating: 7.3
  };

  let surveyStats: SurveyStats = {
    totalSurveys: 420,
    avgSurveysPerDay: 2.3,
    avgQualitativeRating: 7.3
  };


  interface Stats {
    name: string;
    value: number;
    difference: number;
    icon?: any;
  }

  let stats: Stats[] = [];

  $: if ($showSurvey) {
    stats = [
      {
        name: "Total ausgefüllte Umfragen",
        value: surveyStats.totalSurveys,
        difference: -69,
        icon: ClipboardList
      },
      {
        name: "Umfragen pro Tag",
        value: surveyStats.avgSurveysPerDay,
        difference: -0.12,
        icon: CalendarCheck
      },
      {
        name: "Qualitative Bewertung",
        value: surveyStats.avgQualitativeRating,
        difference: 0.3,
        icon: FileLineChart
      }
    ];
  } else {
    stats = [
      {
        name: "Total Gemeinden",
        value: municipalityStats.totalMunicipalities,
        difference: 2,
        icon: Castle
      },
      {
        name: "Quantitative Bewertung",
        value: municipalityStats.avgQuantitativeRating,
        difference: -0.2,
        icon: LineChart
      },
      {
        name: "Qualitative Bewertung",
        value: municipalityStats.avgQualitativeRating,
        difference: 0.3,
        icon: FileLineChart
      }
    ];
  }
</script>

<div>
  <h3 class="text-base font-semibold leading-6 text-neutral mt-3">Letzten 30 Tage</h3>

  <dl class="mt-5 grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
    <div
      class="relative overflow-hidden rounded-lg bg-white px-4 pb-12 pt-5 shadow sm:px-6 sm:pt-6"
    >
      <dt>
        <div class="absolute rounded-md bg-neutral p-3">
          <div
            class="h-6 w-6 text-white"
            in:fly|global={{ y: 50, duration: 100, delay: 100 }}
            out:fly|global={{ y: -50, duration: 100 }}
          >
            <svelte:component this={stats[0].icon} />
          </div>
        </div>
        <p class="ml-16 truncate text-sm font-medium text-gray-500">{stats[0].name}</p>
      </dt>
      <dd class="ml-16 flex items-baseline pb-6 sm:pb-7">

        <p class="text-2xl font-semibold text-gray-900">{stats[0].value}</p>
        <InDecrease difference={stats[0].difference} />
        <div class="absolute inset-x-0 bottom-0 bg-gray-50 px-4 py-4 sm:px-6">
          <div class="text-sm">
            <a href="#" class="font-medium text-neutral hover:text-black"
              >Details<span class="sr-only"> Total Subscribers stats</span></a
            >
          </div>
        </div>
      </dd>
    </div>
    <div
      class="relative overflow-hidden rounded-lg bg-white px-4 pb-12 pt-5 shadow sm:px-6 sm:pt-6"
    >
      <dt>
        <div class="absolute rounded-md bg-neutral p-3">
          <div
            class="h-6 w-6 text-white"
            in:fly|global={{ y: 50, duration: 100, delay: 100 }}
            out:fly|global={{ y: -50, duration: 100 }}
          >
            <svelte:component this={stats[1].icon} />
          </div>
        </div>
        <p class="ml-16 truncate text-sm font-medium text-gray-500">{stats[1].name}</p>
      </dt>
      <dd class="ml-16 flex items-baseline pb-6 sm:pb-7">
        <p class="text-2xl font-semibold text-gray-900">{stats[1].value}</p>
        <InDecrease difference={stats[1].difference} />
        <div class="absolute inset-x-0 bottom-0 bg-gray-50 px-4 py-4 sm:px-6">
          <div class="text-sm">
            <a href="#" class="font-medium text-neutral hover:text-black"
              >Details<span class="sr-only"> Avg. Open Rate stats</span></a
            >
          </div>
        </div>
      </dd>
    </div>
    <div
      class="relative overflow-hidden rounded-lg bg-white px-4 pb-12 pt-5 shadow sm:px-6 sm:pt-6"
    >
      <dt>
        <div class="absolute rounded-md bg-neutral p-3">
          <div
            class="h-6 w-6 text-white"
            in:fly|global={{ y: 50, duration: 100, delay: 100 }}
            out:fly|global={{ y: -50, duration: 100 }}
          >
            <svelte:component this={stats[2].icon} />
          </div>
        </div>
        <p class="ml-16 truncate text-sm font-medium text-gray-500">{stats[2].name}</p>
      </dt>
      <dd class="ml-16 flex items-baseline pb-6 sm:pb-7">
        <p class="text-2xl font-semibold text-gray-900">{stats[2].value}</p>
        <InDecrease difference={stats[2].difference} />
        <div class="absolute inset-x-0 bottom-0 bg-gray-50 px-4 py-4 sm:px-6">
          <div class="text-sm">
            <a href="#" class="font-medium text-neutral hover:text-black"
              >Details<span class="sr-only"> Avg. Click Rate stats</span></a
            >
          </div>
        </div>
      </dd>
    </div>
  </dl>
</div>
