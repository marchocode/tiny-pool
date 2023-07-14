<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-row>
          <el-col :span="8">
            <h3>Tiny-Pool</h3>
          </el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple-light"></div>
          </el-col>
          <el-col :span="8">
            <div class="grid-content bg-purple"></div>
          </el-col>
        </el-row>
      </el-header>
      <el-container>
        <el-aside width="300px">
          <el-menu class="el-menu-vertical-demo" :router=true>

            <el-menu-item index="/">
              <i class="el-icon-menu"></i>
              <span slot="title">总览</span>
            </el-menu-item>

            <el-menu-item index="/pool/default">
              <i class="el-icon-menu"></i>
              <span slot="title">默认线程池</span>
            </el-menu-item>

          </el-menu>

        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
      <el-footer height="30px">
        <el-link type="primary" href="https://github.com/marchocode/tiny-pool">
          https://github.com/marchocode/tiny-pool</el-link>
      </el-footer>
    </el-container>
  </div>
</template>

<style>
body {
  margin: 0;
}

.el-header {
  background-color: #409EFF;
  color: white;
}

.el-aside {
  border-right: solid 1px #e6e6e6;
}

.el-menu {
  border: none;
}

.el-row {
  margin-bottom: 10px;
}

#app .el-container {
  height: 100vh;
}

.el-footer {
  text-align: center;
}

.el-main iframe {
  border: none;
  width: 100%;
  height: 90%;
}
</style>
