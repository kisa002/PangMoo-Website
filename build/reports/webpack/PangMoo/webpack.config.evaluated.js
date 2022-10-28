{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [
    ProgressPlugin {
      profile: false,
      handler: [Function: handler],
      modulesCount: 500,
      showEntries: false,
      showModules: true,
      showActiveModules: true
    },
    TeamCityErrorPlugin {}
  ],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: {
    main: [
      '/Users/holy-knight/Documents/Development/Web/PangMoo/build/js/packages/PangMoo/kotlin/PangMoo.js'
    ]
  },
  output: {
    path: '/Users/holy-knight/Documents/Development/Web/PangMoo/build/distributions',
    filename: [Function: filename],
    library: 'PangMoo',
    libraryTarget: 'umd',
    globalObject: 'this'
  },
  devtool: 'eval-source-map',
  stats: {
    warningsFilter: [
      /Failed to parse source map/
    ],
    warnings: false,
    errors: false
  },
  devServer: {
    open: true,
    contentBase: [
      '/Users/holy-knight/Documents/Development/Web/PangMoo/build/processedResources/js/main'
    ]
  }
}