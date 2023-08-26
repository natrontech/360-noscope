<script lang="ts">
  import "../app.postcss";
  import "../app.css";
  import { metadata } from "$lib/stores/metadata";
  import { site } from "$lib/config";
  import { beforeNavigate } from "$app/navigation";
  import { Toaster } from "svelte-french-toast";

  $: title = $metadata.title ? $metadata.title + " | " + site.name : site.name;
  $: description = $metadata.description ?? site.description;

  // reset metadata on navigation so that the new page inherits nothing from the old page
  beforeNavigate(() => {
    $metadata = {};
  });

  import Particles from "svelte-particles";
  //import { loadFull } from "tsparticles"; // if you are going to use `loadFull`, install the "tsparticles" package too.
  import { loadSlim } from "tsparticles-slim"; // if you are going to use `loadSlim`, install the "tsparticles-slim" package too.

  let particlesConfig = {
    particles: {
      color: {
        value: "#0e0e0e"
      },
      links: {
        enable: true,
        color: "#0e0e0e"
      },
      move: {
        enable: true
      },
      number: {
        value: 50
      }
    }
  };

  let onParticlesLoaded = (event: any) => {
    const particlesContainer = event.detail.particles;

    // you can use particlesContainer to call all the Container class
    // (from the core library) methods like play, pause, refresh, start, stop
  };

  let particlesInit = async (engine: any) => {
    // you can use main to customize the tsParticles instance adding presets or custom shapes
    // this loads the tsparticles package bundle, it's the easiest method for getting everything ready
    // starting from v2 you can add only the features you need reducing the bundle size
    //await loadFull(engine);
    await loadSlim(engine);
  };
</script>

<svelte:head>
  <title>{title}</title>
  <meta name="description" content={description} />
</svelte:head>

<div class="h-full relative">
  <Particles
    id="tsparticles"
    class=""
    style=" z-index: -100; position: absolute; top: 0; left: 0; right: 0; bottom: 0;"
    options={particlesConfig}
    on:particlesLoaded={onParticlesLoaded}
    {particlesInit}
  />
  <Toaster position="top-center" />
  <!-- only display nav when not on /login -->
  <slot />
</div>
