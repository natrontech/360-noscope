/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: "class",
  content: ["./src/**/*.{html,js,svelte,ts}"],
  theme: {
    extend: {
      screens: {
        "hover-hover": { raw: "(hover: hover)" }
      },
      height: {
        '128': '32rem',
      },
      keyframes: {
        wiggle: {
          '0%, 100%': { transform: 'rotate(-0.5deg)' },
          '50%': { transform: 'rotate(0.5deg)' },
        }
      },
      animation: {
        wiggle: 'wiggle 1s ease-in-out infinite',
      }
    }
  },
  plugins: [
    require("@tailwindcss/forms"),
    require("@tailwindcss/typography"),
    require("@tailwindcss/line-clamp"),
    require("tailwind-scrollbar"),
    require("daisyui")
  ],
  daisyui: {
    logs: false,
    themes: ["emerald"],
  },
};
