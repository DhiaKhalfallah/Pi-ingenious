
/**
* @property {HTMLElement} content
* @property {HTMLFormElement} form
*/
export default class Filterr { 
 /**
 * @param {HTMLElement|null}element
 */

    constructor(element){
        if(element ==null){
            retun
        }
        this.content=element.querySelector('js-filter-content')    
        this.form=element.querySelector('js-filter-form')    
        this.bindEvents()

    }
    bindEvents(){

    }




}