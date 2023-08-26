<script lang="ts">
  import ShowSurveyToggle from "$lib/components/base/ShowSurveyToggle.svelte";
  import { client, logout } from "$lib/pocketbase";
  import { Search } from "lucide-svelte";
  import { avatarUrl } from '$lib/utils/user.utils';
  import { goto } from '$app/navigation';
  import Notification from '$lib/components/base/Notification.svelte';

  const avatar = avatarUrl();
  function goHome() {
    goto('/app');
  }
  let showNotifications = false;
</script>

<div>
  <div class="absolute bg-neutral top-0 -z-10 right-0 bottom-3/4 inset-0" />
  <div class="absolute bg-white top-0 -z-20 right-0 bottom-3/4 inset-0" />
  <div>
    <div
      class="sticky top-0 z-40 flex h-16 shrink-0 items-center gap-x-4 px-4  sm:gap-x-6 sm:px-6 lg:px-8"
    >
      <div class="flex-shrink-0">
        <img class="block h-12 w-12 cursor-pointer" src="/images/360-noscope.png" alt="360-noscope" on:click={goHome} />
      </div>

      <!-- Separator -->
      <div class="h-6 w-px bg-white lg:hidden" aria-hidden="true" />

      <div class="flex flex-1 gap-x-4 self-stretch lg:gap-x-6">
        <form class="relative flex flex-1" action="#" method="GET">
          <label for="search-field" class="sr-only">Search</label>
          <Search class="pointer-events-none absolute inset-y-0 left-0 h-full w-5 text-white" />
          <input
            id="search-field"
            class="block h-full w-full border-0 py-0 pl-8 pr-0 bg-transparent focus:ring-0 sm:text-sm placeholder-gray-50 text-white"
            placeholder="Suche..."
            type="text"
            name="search"
          />
        </form>
        <div class="flex items-center gap-x-4 lg:gap-x-6">
          <div class="relative">
          <button type="button" class="-m-2.5 p-2.5" on:click={() => showNotifications = !showNotifications}>
            <span class="sr-only">View notifications</span>
            <svg
              class="h-6 w-6"
              fill="{showNotifications ? 'currentColor' : 'none'}"
              viewBox="0 0 24 24"
              stroke-width="1.5"
              stroke="currentColor"
              aria-hidden="true"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0"
              />
            </svg>
          </button>
            {#if showNotifications}
              <Notification />
            {/if}
          </div>

          <!-- Separator -->
          <div class="hidden lg:block lg:h-6 lg:w-px lg:bg-white" aria-hidden="true" />

          <!-- Profile dropdown -->
          <div class="relative">
            <div class="dropdown dropdown-bottom dropdown-end">
              <button
                type="button"
                class="-m-1.5 flex items-center p-2.5 "
                id="user-menu-button"
                aria-expanded="false"
                aria-haspopup="true"
                tabIndex={0}
              >
                <span class="sr-only">Open user menu</span>
                <img
                  class="h-8 w-8 rounded-full bg-white"
                  src={avatar}
                  alt=""
                />
                <span class="hidden lg:flex lg:items-center">
                  <span
                    class="ml-4 text-sm font-semibold leading-6 text-white"
                    aria-hidden="true">{client.authStore.model?.name}</span
                  >
                  <svg
                    class="ml-2 h-5 w-5 text-white"
                    viewBox="0 0 20 20"
                    fill="currentColor"
                    aria-hidden="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M5.23 7.21a.75.75 0 011.06.02L10 11.168l3.71-3.938a.75.75 0 111.08 1.04l-4.25 4.5a.75.75 0 01-1.08 0l-4.25-4.5a.75.75 0 01.02-1.06z"
                      clip-rule="evenodd"
                    />
                  </svg>
                </span>
              </button>

              <ul
                tabIndex={0}
                class="dropdown-content z-[1] menu mt-3 p-2 shadow bg-base-100 rounded-box w-52"
              >
                <li><a href="/app/profile">Dein Profil</a></li>
                <li><button on:click={() => logout()}>Abmelden</button></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Controls -->
    <div class="flex content-center h-20 px-10">
      <ShowSurveyToggle />
    </div>

    <!-- Main content -->
    <div
      class="absolute top-40 bottom-10 left-10 right-10 bg-white p-10 overflow-y-scroll scrollbar-thin rounded-lg shadow-md"
    >
      <slot />
    </div>
  </div>
</div>
