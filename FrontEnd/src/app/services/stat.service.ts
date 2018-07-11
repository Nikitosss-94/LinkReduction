import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

 //—ервер, св€зывающий web-приложение с сервером.

@Injectable()
export class StatService {
  private baseUrl:string='http://localhost:8080';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private _http:Http) { }
 
  redirect(id:Number) {
    return this._http.get(this.baseUrl + '/' + id, this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
  }

  reduct(url:String) {
    return this._http.get(this.baseUrl + '/?url=' + url, this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
  }

  allstat() {
    return this._http.get(this.baseUrl + '/allstat', this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
  }

  stat(id:Number) {
    return this._http.get(this.baseUrl + '/stat=' + id, this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
  }

  errorHandler(error:Response) {
    return Observable.throw(error||"SERVER ERROR");
  }
}