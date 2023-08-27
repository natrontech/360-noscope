<script lang="ts">
  export let label = "Button";
  export let icon: any = null;

  export let loading: boolean = false;
</script>

<button class="button btn ring-4">
  <div class="content">
    {#if !loading}
      {#if icon}
        <svelte:component this={icon} class="mr-2 inline h-8 w-8" />
      {/if}
      {label}
    {:else}
      <span class="loading loading-dots loading-sm" />
    {/if}
  </div>
</button>

<style>
  @property --rotate {
    syntax: "<angle>";
    initial-value: 132deg;
    inherits: false;
  }

  :root {
    --button-height: 50px;
    --button-width: calc(var(--button-height) * 2.5);
  }

  .button .content {
    z-index: 2;
    position: relative;
  }

  .button {
    z-index: 2;
    background: #212534;
    width: var(--button-width);
    height: var(--button-height);
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
    z-index: 10;
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
    z-index: 0;
    content: "";
    width: 104%;
    height: 104%;
    border-radius: 8px;
    background-image: linear-gradient(var(--rotate), #5ddcff, #3c67e3 43%, #4e00c2);
    position: absolute;
    top: -2%;
    bottom: -2%;
    left: -2%;
    transition: all 0.5s;
    animation: spin 2.5s linear infinite;
  }

  .button::after {
    z-index: 0;
    position: absolute;
    content: "";
    top: calc(var(--button-height) / 6);
    left: 0;
    right: 0;
    height: 100%;
    width: 100%;
    margin: 0 auto;
    transform: scale(0.8);
    filter: blur(calc(var(--button-height) / 6));
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
