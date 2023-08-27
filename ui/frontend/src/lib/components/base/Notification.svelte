<script lang="ts">
    import { fly } from 'svelte/transition';
    import { goto } from '$app/navigation';

    function open(url: string) {
        goto(url);
    }
</script>

<div class="absolute left-1/2 z-10 mt-5 flex w-screen max-w-max -translate-x-1/2 px-4" in:fly={{ y: -50, duration: 300 }} out:fly={{ y: -50, duration: 300 }}>
    <div class="w-screen max-w-sm flex-auto rounded-3xl bg-white p-4 text-sm leading-6 shadow-lg ring-1 ring-gray-900/5">
        <div class="relative rounded-lg p-4 bg-gray-100" on:click={() => open("/survey/1bm2o25y8vvu39s/")}>
            <a href="#" class="font-semibold text-gray-900">
                Neue Umfrage gestartet - Heute
                <span class="absolute inset-0"></span>
            </a>
            <p class="mt-1 text-gray-600">Nachhaltigkeitsumfrage 2023 für Grindelwald</p>
        </div>
        <div class="relative rounded-lg p-4 hover:bg-gray-50" on:click={() => open("/survey/gg6ufvtekeuxuvp/")}>
            <a href="#" class="font-semibold text-gray-900">
                100 Antworten überschritten - Gestern
                <span class="absolute inset-0"></span>
            </a>
            <p class="mt-1 text-gray-600">Bern hat 100 Antworten erreicht</p>
        </div>
        <div class="relative rounded-lg p-4 hover:bg-gray-50" on:click={() => open("/survey/xfhg75vxumhixpv/")}>
            <a href="#" class="font-semibold text-gray-900">
                Umfrage abgeschlossen - Donnerstag
                <span class="absolute inset-0"></span>
            </a>
            <p class="mt-1 text-gray-600">Nachhaltigkeitsumfrage 2023 für Herzogenbuchsee</p>
        </div>
    </div>
</div>
