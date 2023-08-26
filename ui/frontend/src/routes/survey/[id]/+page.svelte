<script lang="ts">
  import { metadata } from "$lib/stores/metadata";
  import { Frown, Check } from "lucide-svelte";
  import Devider from "$lib/components/base/Devider.svelte";
  import Slider from "$lib/components/base/Sliderl.svelte";

  $metadata.title = "Survey";

  export let data;

  let sent = false;

  async function submit() {
    sent = true;
    const result = {
        id: data.survey?.id,
        questions: data.questions?.map(q => ({ id: q.questionId, answer: q.answer, question: q.question, indicator: q.indicator })),
    }
    // ToDo: send result to backend
    console.log(result);
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

{#if !data.participant.canSubmit}
  <div class="inline-flex items-center w-full flex justify-center">
    <h1 class="m-0">Umfrage ist geschlossen. Keine Antworten mehr möglich.</h1>
  </div>
{/if}

{#if data.survey && !sent && data.participant.canSubmit}
  <h1>{data.survey.name}</h1>
  <h2>{data.municipality.plz} {data.municipality.name}</h2>

  <Devider />

  <p class="mb-10">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

  <h3>Offene Fragen</h3>

  <div class="form-control mb-5">
    <label class="label">
      <span class="label-text">Was macht deine Gemeinde gut?</span>
    </label>
    <textarea class="textarea textarea-bordered h-24"></textarea>
  </div>

  <div class="form-control">
    <label class="label">
      <span class="label-text">Was macht deine Gemeinde schlecht?</span>
    </label>
    <textarea class="textarea textarea-bordered h-24"></textarea>
  </div>

  <Devider />

  <h3>Qualitative Fragen</h3>

  <form on:submit|preventDefault={submit}>
    <div>
      <div class="space-y-12 flex flex-col w-full xl:w-3/4">
        {#each data.questions as question, index}
          <p>{index + 1}) {question.question}</p>
          <Slider bind:value={question.answer} on:change={e => question.answer = e.detail} />
        {/each}
      </div>
    </div>

    <Devider />

   <h3>Demografische Fragen</h3>

    <div class="form-control w-full max-w-xs mb-5">
      <label class="label">
        <span class="label-text">Geschlecht</span>
      </label>
      <select required class="select select-bordered">
        <option disabled selected>Auswählen</option>
        <option>Männlich</option>
        <option>Weiblich</option>
        <option>Divers</option>
      </select>
    </div>

    <div class="form-control w-full max-w-xs">
      <label class="label">
        <span class="label-text">Alter</span>
      </label>
      <input type="number" min="0" required class="input input-bordered w-full max-w-xs" />
    </div>

    <Devider />

    <div class="mt-6 flex items-center justify-end gap-x-6">
      <button type="submit" class="btn btn-primary">Abschicken</button>
    </div>
  </form>
{/if}
