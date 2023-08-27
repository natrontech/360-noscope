<script lang="ts">
  import BarChart from "$lib/components/data/Diagrams/BarChart.svelte";
  import RadarChart from "$lib/components/data/Diagrams/RadarChart.svelte";
  import { ArrowLeft, Share } from "lucide-svelte";
    import toast from "svelte-french-toast";

  function getRandomData(min: number, max: number) {
    return (Math.random() * (max - min) + min).toFixed(1);
  }

  let randomData = [
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10)
  ];

  let randomData2 = [
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10),
    getRandomData(0, 10)
  ];
</script>

<div class="flex justify-between">
  <a class="btn btn-neutral" href="/app"><ArrowLeft /> Zurück</a>
  <h1 class="text-2xl font-semibold text-center">Analyse</h1>
  <button class="btn btn-neutral"
    on:click={() => {
      navigator.clipboard.writeText(window.location.href);
      toast.success("Link kopiert");
    }}
  ><Share /> Teilen</button>
</div>
<div class="grid grid-cols-1 gap-2">
  <div class="flex flex-col items-center justify-center w-full h-128">
    <RadarChart {randomData} {randomData2} />
  </div>
  <div class="flex flex-col items-center justify-center w-full h-96">
    <BarChart {randomData} {randomData2} />
  </div>
</div>
