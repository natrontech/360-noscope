<script lang="ts">
  export let quantitativeRating: number;
  export let qualitativeRating: number;

  export let black: string = "#333C4D";
  export let green: string = "#10b981";
  export let yellow: string = "#fbbf24";
  export let orange: string = "#f59e0b";
  export let red: string = "#ef4444";

  export let blue: string = "#3b82f6";
  export let purple: string = "#a855f7";

  // Calculate X position for each point
  function calculateX(value: number, max: number, width: number) {
    return (value / max) * width;
  }

  // Calculate color based on the absolute difference
  function calculateColor() {
    const difference = Math.abs(quantitativeRating - qualitativeRating);
    if (difference <= 0.5) return green;
    if (difference <= 1) return yellow;
    if (difference <= 1.5) return orange;
    return red;
  }

  const minRating = Math.min(quantitativeRating, qualitativeRating);
  const maxRating = Math.max(quantitativeRating, qualitativeRating);
</script>

<div class="">
  <svg class="container" viewBox="0 0 150 20">
    <line class="axis" x1="1" y1="10" x2={calculateX(minRating, 10, 100)} y2="10" stroke={black} />
    <line
      class="axis"
      x1={calculateX(minRating, 10, 100)}
      y1="10"
      x2={calculateX(maxRating, 10, 100)}
      y2="10"
      stroke={calculateColor()}
    />
    <line class="axis" x1={calculateX(maxRating, 10, 100)} y1="10" x2="99" y2="10" stroke={black} />
    <line
      stroke={blue}
      class="line"
      x1={calculateX(quantitativeRating, 10, 100)}
      y1="7"
      x2={calculateX(quantitativeRating, 10, 100)}
      y2="13"
    />
    <line
      stroke={purple}
      class="line"
      x1={calculateX(qualitativeRating, 10, 100)}
      y1="7"
      x2={calculateX(qualitativeRating, 10, 100)}
      y2="13"
    />
    <text x={calculateX(quantitativeRating, 10, 100) - 1.5} y="4" class="label">
      {quantitativeRating}</text
    >
    <text x={calculateX(qualitativeRating, 10, 100) - 1.5} y="19" class="label"
      >{qualitativeRating}</text
    >

    <!-- Legend -->
    <circle cx="114" cy="6.5" r="2" class="quantitative_point" stroke={blue} fill-opacity={0} />
    <circle cx="114" cy="12" r="2" class="qualitative_point" stroke={purple} fill-opacity={0} />
    <text x="118" y="8" class="label">Quantitativ</text>
    <text x="118" y="13" class="label">Qualitativ</text>
  </svg>
</div>

<style>
  .container {
    position: relative;
    width: 30rem;
    height: auto;
  }

  .axis {
    stroke-width: 2;
    stroke-linecap: round;
  }

  .line {
    stroke-width: 2;
    stroke-linecap: round;
  }

  .label {
    font-size: 4px;
    text-anchor: start;
    /* bold */
    font-weight: 500;
  }
</style>
