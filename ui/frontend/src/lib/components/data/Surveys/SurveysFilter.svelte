<script>
  // TODO: Add geo filter
</script>

<div class="">
  <!-- Filters -->
  <section aria-labelledby="filter-heading">
    <h2 id="filter-heading" class="sr-only">Filters</h2>

    <div class="border-b-2 border-neutral  pb-4">
      <div class="mx-auto flex max-w-7xl items-center justify-between px-1">
        <div class="relative inline-block text-left">
          <div>
            <button
              type="button"
              class="group inline-flex justify-center text-sm font-medium text-gray-700 hover:text-gray-900"
              id="menu-button"
              aria-expanded="false"
              aria-haspopup="true"
            >
              Sort
              <svg
                class="-mr-1 ml-1 h-5 w-5 flex-shrink-0 text-gray-400 group-hover:text-gray-500"
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
            </button>
          </div>
          <!-- <div
            class="absolute left-0 z-10 mt-2 w-40 origin-top-left rounded-md bg-white shadow-2xl ring-1 ring-black ring-opacity-5 focus:outline-none"
            role="menu"
            aria-orientation="vertical"
            aria-labelledby="menu-button"
            tabindex="-1"
          >
            <div class="py-1" role="none">
              <a
                href="#"
                class="font-medium text-gray-900 block px-4 py-2 text-sm"
                role="menuitem"
                tabindex="-1"
                id="menu-item-0">Most Popular</a
              >
              <a
                href="#"
                class="text-gray-500 block px-4 py-2 text-sm"
                role="menuitem"
                tabindex="-1"
                id="menu-item-1">Best Rating</a
              >
              <a
                href="#"
                class="text-gray-500 block px-4 py-2 text-sm"
                role="menuitem"
                tabindex="-1"
                id="menu-item-2">Newest</a
              >
            </div>
          </div> -->
        </div>

        <button
          type="button"
          class="inline-block text-sm font-medium text-gray-700 hover:text-gray-900 sm:hidden"
          >Filter</button
        >

        <div class="hidden sm:block">
          <div class="flow-root">
            <div class="-mx-4 flex items-center">
              <div class="relative inline-block px-4 text-left">
                <button
                  type="button"
                  class="group inline-flex justify-center text-sm font-medium text-gray-700 hover:text-gray-900"
                  aria-expanded="false"
                >
                  <span>Gemeinden</span>
                  <span
                    class="ml-1.5 rounded bg-gray-200 px-1.5 py-0.5 text-xs font-semibold tabular-nums text-gray-700"
                    >Bern</span
                  >
                  <span
                    class="ml-1.5 rounded bg-gray-200 px-1.5 py-0.5 text-xs font-semibold tabular-nums text-gray-700"
                    >Zürich</span
                  >
                  <span
                    class="ml-1.5 rounded bg-gray-200 px-1.5 py-0.5 text-xs font-semibold tabular-nums text-gray-700"
                    >+2</span
                  >
                  <svg
                    class="-mr-1 ml-1 h-5 w-5 flex-shrink-0 text-gray-400 group-hover:text-gray-500"
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
                </button>

                <!-- <div
                  class="absolute right-0 z-10 mt-2 origin-top-right rounded-md bg-white p-4 shadow-2xl ring-1 ring-black ring-opacity-5 focus:outline-none"
                >
                  <form class="space-y-4">
                    <div class="flex items-center">
                      <input
                        id="filter-category-0"
                        name="category[]"
                        value="new-arrivals"
                        type="checkbox"
                        class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                      />
                      <label
                        for="filter-category-0"
                        class="ml-3 whitespace-nowrap pr-6 text-sm font-medium text-gray-900"
                        >All New Arrivals</label
                      >
                    </div>
                    <div class="flex items-center">
                      <input
                        id="filter-category-1"
                        name="category[]"
                        value="tees"
                        type="checkbox"
                        class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                      />
                      <label
                        for="filter-category-1"
                        class="ml-3 whitespace-nowrap pr-6 text-sm font-medium text-gray-900"
                        >Tees</label
                      >
                    </div>
                    <div class="flex items-center">
                      <input
                        id="filter-category-2"
                        name="category[]"
                        value="objects"
                        type="checkbox"
                        checked
                        class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                      />
                      <label
                        for="filter-category-2"
                        class="ml-3 whitespace-nowrap pr-6 text-sm font-medium text-gray-900"
                        >Objects</label
                      >
                    </div>
                  </form>
                </div> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
