<script lang="ts">
    import { onMount } from "svelte";

  interface RatingLabel {
    label: string;
    color: string;
  }

  let rating: RatingLabel = {
    label: "",
    color: "",
  };



  function driftRating(quantitative: number, qualitative: number) {
    // drift is absolute value of difference between quantitative and qualitative rating
    // if drift is 0, then rating.label is "sehr gut" and rating.color is "green"
    // if drift is > 0.5 then rating.label is "gut" and rating.color is "yellow"
    // if drift is > 1 then rating.label is "genügend" and rating.color is "orange"
    // if drift is > 1.5 then rating.label is "ungenügend" and rating.color is "red"

    let drift = Math.abs(quantitative - qualitative);

    // round drift to 1 decimal place
    drift = Math.round(drift * 10) / 10;

    console.log(drift);

    if (drift >= 0 && drift <= 0.5) {
      rating = {
        label: "sehr gut",
        color: "green",
      };
    } else if (drift > 0.5 && drift <= 1) {
      rating = {
        label: "gut",
        color: "yellow",
      };
    } else if (drift > 1 && drift <= 1.5) {
      rating = {
        label: "genügend",
        color: "orange",
      };
    } else if (drift > 1.5) {
      rating = {
        label: "ungenügend",
        color: "red",
      };
    }
  }

  export let quantitativeRating: number;
  export let qualitativeRating: number;

  onMount(() => {
    driftRating(quantitativeRating, qualitativeRating);
    console.log(rating);
  });



</script>

<p
  class="rounded-md whitespace-nowrap mt-0.5 px-1.5 py-0.5 text-xs font-medium ring-1 ring-inset text-{rating.color}-700 bg-{rating.color}-50 ring-{rating.color}-600/20"
>
{rating.label}
</p>
