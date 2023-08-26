<script>
    export let value = 0;
    import { createEventDispatcher } from 'svelte';
    const dispatch = createEventDispatcher();

    function handleValueChange(event) {
        dispatch('change', +event.target.value);
    }
</script>

<input type="range" min="0" max="10" value={value} class="range" step="1" on:input={handleValueChange} />
<div class="w-full flex justify-between text-xs px-2">
    <span>0</span>
    <span>1</span>
    <span>2</span>
    <span>3</span>
    <span>4</span>
    <span>5</span>
    <span>6</span>
    <span>7</span>
    <span>8</span>
    <span>9</span>
    <span>10</span>
</div>
