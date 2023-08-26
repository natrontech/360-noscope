<script lang="ts">
  export let label = "Button";
  export let icon: any = null;
</script>

<button class="button btn ring-4">
  {#if icon}
    <svelte:component this={icon} class="mr-2 inline h-8 w-8" />
  {/if}
  {label}
</button>

<style>
  @property --rotate {
    syntax: "<angle>";
    initial-value: 132deg;
    inherits: false;
  }

  :root {
    --card-height: 50px;
    --card-width: calc(var(--card-height) * 2.5);
  }

  .button {
    background: #212534;
    width: var(--card-width);
    height: var(--card-height);
    padding: 3px;
    position: relative;
    border-radius: 10px;
    justify-content: center;
    align-items: center;
    text-align: center;
    display: flex;
    font-size: 1em;
    cursor: pointer;
    color: white;
  }

  .button:hover {
    background: white;
    color: #212534;
    transition: all 0.5s;
  }
  .button:hover:before,
  .button:hover:after {
    animation: none;
    opacity: 0;
    transition: all 0.5s;
  }

  .button::before {
    content: "";
    width: 104%;
    height: 104%;
    border-radius: 8px;
    background-image: linear-gradient(var(--rotate), #5ddcff, #3c67e3 43%, #4e00c2);
    position: absolute;
    z-index: -1;
    top: -2%;
    bottom: -2%;
    left: -2%;
    transition: all 0.5s;
    animation: spin 2.5s linear infinite;
  }

  .button::after {
    position: absolute;
    content: "";
    top: calc(var(--card-height) / 6);
    left: 0;
    right: 0;
    z-index: -1;
    height: 100%;
    width: 100%;
    margin: 0 auto;
    transform: scale(0.8);
    filter: blur(calc(var(--card-height) / 6));
    background-image: linear-gradient(var(--rotate), #5ddcff, #3c67e3 43%, #4e00c2);
    opacity: 1;
    transition: opacity 0.5s;
    transition: all 0.5s;
    animation: spin 2.5s linear infinite;
  }

  @keyframes spin {
    0% {
      --rotate: 0deg;
    }
    100% {
      --rotate: 360deg;
    }
  }
</style>
