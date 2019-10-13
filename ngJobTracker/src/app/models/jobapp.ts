import { User } from './user';
import { Tech } from './tech';

export class Jobapp {

    id: number;
    title: string;
    link: string;
    contactName: string;
    contactNotes: string;
    additionalNotes: string;
    status: string;
    user: User;
    technologies: Tech[];

    constructor(
      id?: number,
      title?: string,
      link?: string,
      contactName?: string,
      contactNotes?: string,
      additionalNotes?: string,
      status?: string,
      user?: User,
      technologies?: Tech[] // can remove ? and provide default (completed: false)
    ) {
      this.id = id;
      this.title = title;
      this.link = link;
      this.contactName = contactName;
      this.contactNotes = contactNotes;
      this.additionalNotes = additionalNotes;
      this.status = status;
      this.user = user;
      this.technologies = technologies;



    }
















}
