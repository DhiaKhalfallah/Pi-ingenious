/**
* @property {HTMLElement}sorting
* @property {HTMLElement}article
*/

export default class Filterr {

    /**
     * @param {HTMLElement|null}element
     */
    constructor (element){
        if (element === null){
         return
        }
    console.log("hello")
    this.sorting = element.querySelector('.js-filter-button1')
    this.article = element.querySelector('.js-filter-article')
    this.bindEvents()
    }

    bindEvents(){
        this.sorting.querySelectorAll('a').forEach(a => {
            a.addEventListener('click' , e =>{
                e.preventDefault()
                this.loadUrl(a.getAttribute('href'))
            })
        });
    }
    async loadUrl(url){
        const reponse = await fetch (url ,{
            headers :{
                'x-Requestes-With' : 'XMLHttpRequest'
            }
        })
        if( Response.status >= 200 && Response.status > 300 ){
            const data= await Response.json()
            this.content.innerHTML =data.content
        }else {
            console.error(reponse)
        }
        
    }

    
}
