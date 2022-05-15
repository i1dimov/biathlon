class Router{

    constructor(paths) {
        this.paths = paths
        this.initRouter()
    }

    initRouter(){
        const{
            location: {pathname = '/'}
        } = window
        const URI = pathname === '/' ? 'home' : pathname.replace('/', '')
        this.load(URI)
    }

    load(page = 'home'){
        const { paths } = this
        console.log(page)
        console.log(paths[page])
        const {path, template} = paths[page] || paths.error;
        const $CONTAINER = document.querySelector('html')
        console.log(path)
        history.pushState({},'',path)
    }
}