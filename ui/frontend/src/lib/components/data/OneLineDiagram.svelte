<script lang="ts">
  export let quantitativeRating: number;
  export let qualitativeRating: number;

  // Calculate X position for each point
  function calculateX(value, max, width) {
      return (value / max) * width;
  }
</script>

<style>
  .container {
      position: relative;
      width: 100%;
      height: 100%;
  }

  .axis {
      stroke: black;
      stroke-width: 2;
  }

  .point {
      stroke: red;
      stroke-width: 2;
  }

  .label {
      font-size: 3px;
  }
</style>

<svg class="container" viewBox="0 0 100 20">
  <line class="axis" x1="0" y1="10" x2="100" y2="10" />
  <line class="point" x1={calculateX(quantitativeRating, 10, 100)} y1="5" x2={calculateX(quantitativeRating, 10, 100)} y2="15" />
  <line class="point" x1={calculateX(qualitativeRating, 10, 100)} y1="5" x2={calculateX(qualitativeRating, 10, 100)} y2="15" />
  <text class="label" x={calculateX(quantitativeRating, 10, 100)} y="4" text-anchor="middle">{quantitativeRating}</text>
  <text class="label" x={calculateX(qualitativeRating, 10, 100)} y="4" text-anchor="middle">{qualitativeRating}</text>
  <text class="label" x={(calculateX(quantitativeRating, 10, 100) + calculateX(qualitativeRating, 10, 100)) / 2} y="18" text-anchor="middle">{(quantitativeRating + qualitativeRating) / 2}</text>
</svg>
