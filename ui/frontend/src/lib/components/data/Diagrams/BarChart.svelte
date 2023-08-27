<script lang="ts">
  import { Bar } from "svelte-chartjs";
  // import { data } from "./bar-data.js";

  import { Chart, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from "chart.js";

  Chart.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale);

  export let randomData: string[] = [];
  export let randomData2: string[] = [];

  let data = {
    labels: [
        'Sicherheit',
        'Gesundheit',
        'Umwelt',
        'Verkehr',
        'Bildung',
        'Wirtschaft',
        'Kultur',
    ],
    datasets: [
        {
            label: 'Quantitative Data',
            backgroundColor: 'rgba(194, 116, 161, 0.5)',
            borderColor: 'rgb(194, 116, 161)',
            data: randomData
        },
        {
            label: 'Qualitative Data',
            backgroundColor: 'rgba(71, 225, 167, 0.5)',
            borderColor: 'rgb(71, 225, 167)',
            data: randomData2
        },
    ],
};
</script>

<Bar {data} options={{ responsive: true }} />
