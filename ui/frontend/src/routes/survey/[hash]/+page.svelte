<script lang="ts">
  import { metadata } from "$lib/stores/metadata";
  import { Frown, Check } from "lucide-svelte";
  import Devider from "$lib/components/devider/Devider.svelte";

  $metadata.title = "Survey";

  export let data;

  let sent = false;

  function submit() {
    sent = true;
    console.log(data.questions);
  }
</script>

{#if !data.survey}
  <div class="inline-flex items-center w-full flex justify-center">
    <h1 class="m-0">Keine Umfrage gefunden</h1>
    <Frown class="ml-5" />
  </div>
{/if}

{#if sent}
  <div class="inline-flex items-center w-full flex justify-center">
    <h1 class="m-0">Umfrage erfolgreich abgeschickt</h1>
    <Check class="ml-5" />
  </div>
{/if}

{#if data.survey && !sent}
  <h1>{data.survey.name}</h1>

  <Devider />

  <form on:submit|preventDefault={submit}>
    <div>
      <div class="space-y-12 flex flex-col w-full lg:w-1/2">
        {#each data.questions as question}
          {#if question.type === "number"}
            <div class="form-control">
              <label class="label">
                <span class="label-text">{question.question}</span>
              </label>
              <input
                type="number"
                class="input input-bordered w-full xl:w-1/2"
                bind:value={question.answer}
              />
            </div>
          {/if}

          {#if question.type === "bool"}
            <label class="label cursor-pointer w-fit">
              <input type="checkbox" class="checkbox mr-5" bind:checked={question.answer} />
              <span class="label-text">{question.question}</span>
            </label>
          {/if}
        {/each}
      </div>
    </div>

    <Devider />

    <div class="mt-6 flex items-center justify-end gap-x-6">
      <button type="submit" class="btn btn-primary">Abschicken</button>
    </div>
  </form>
{/if}
