<script lang="ts">
  import { Radar } from "svelte-chartjs";

  import {
    Chart as ChartJS,
    Title,
    Tooltip,
    Legend,
    PointElement,
    RadialLinearScale,
    LineElement
  } from "chart.js";

  ChartJS.register(Title, Tooltip, Legend, PointElement, RadialLinearScale, LineElement);

  export let randomData: string[] = [];
  export let randomData2: string[] = [];

  const data = {
    labels: ["Sicherheit", "Gesundheit", "Umwelt", "Verkehr", "Bildung", "Wirtschaft", "Kultur"],
    datasets: [
      {
        label: "Quantitative Data",
        backgroundColor: "rgba(194, 116, 161, 0.5)",
        borderColor: "rgb(194, 116, 161)",
        data: randomData
      },
      {
        label: "Qualitative Data",
        backgroundColor: "rgba(71, 225, 167, 0.5)",
        borderColor: "rgb(71, 225, 167)",
        data: randomData2
      }
    ]
  };
</script>

<Radar {data} options={{ responsive: true }} />
