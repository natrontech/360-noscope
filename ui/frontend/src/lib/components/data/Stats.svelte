<script lang="ts">
  import showSurvey from "$lib/stores/toggle";
  import { Calendar, CalendarCheck, Castle, ClipboardCheck, ClipboardList, Star } from "lucide-svelte";
    import InDecrease from "./InDecrease.svelte";

  let totalSurveys = 20;
  let avgSurveyPerDay = 2;
  let avgScorePerSurvey = 8.2;

  let totalMunicipalities = 10;
  let avgSurveyPerMunicipality = 2;
  let avgScorePerMunicipality = 6.8;
  let avgScoreSurveyDrift = 1.4;

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
        value: totalSurveys,
        difference: -2,
        icon: ClipboardList
      },
      {
        name: "Durchschnittliche Umfragen pro Tag",
        value: avgSurveyPerDay,
        difference: 2,
        icon: CalendarCheck
      },
      {
        name: "Durchschnittliche Bewertung pro Umfrage",
        value: avgScorePerSurvey,
        difference: 2,
        icon: Star
      }
    ];
  } else {
    stats = [
      {
        name: "Total Gemeinden",
        value: totalMunicipalities,
        difference: 2,
        icon: Castle
      },
      {
        name: "Durchschnittliche Umfragen pro Gemeinde",
        value: avgSurveyPerMunicipality,
        difference: 2,
        icon: ClipboardCheck
      },
      {
        name: "Durchschnittliche Bewertung pro Gemeinde",
        value: avgScorePerMunicipality,
        difference: -0.2,
        icon: Star
      },
    ];
  }

</script>

{#key showSurvey}
  <div>
    <h3 class="text-base font-semibold leading-6 text-gray-900">Letzten 30 Tage</h3>

    <dl class="mt-5 grid grid-cols-1 gap-5 sm:grid-cols-2 lg:grid-cols-3">
      <div
        class="relative overflow-hidden rounded-lg bg-white px-4 pb-12 pt-5 shadow sm:px-6 sm:pt-6"
      >
        <dt>
          <div class="absolute rounded-md bg-primary p-3">
            <div class="h-6 w-6 text-white">
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
              <a href="#" class="font-medium text-primary hover:text-primary"
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
          <div class="absolute rounded-md bg-primary p-3">
            <div class="h-6 w-6 text-white">
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
              <a href="#" class="font-medium text-primary hover:text-primary"
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
          <div class="absolute rounded-md bg-primary p-3">
            <div class="h-6 w-6 text-white">
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
              <a href="#" class="font-medium text-primary hover:text-primary"
                >Details<span class="sr-only"> Avg. Click Rate stats</span></a
              >
            </div>
          </div>
        </dd>
      </div>
    </dl>
  </div>
{/key}
