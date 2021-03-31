<?php

namespace App\Controller;

use DateTimeInterface;
use App\Entity\Interview;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class ApiController extends AbstractController
{
    /**
     * @Route("/api", name="api")
     */
    public function index(): Response
    {
        return $this->render('api/index.html.twig', [
            'controller_name' => 'ApiController',
        ]);
    }
        
    /**
     * @Route("/api/{id}/edit", name="api_edit", methods={"PUT"})
     */
    public function editinterview ( ?Interview $interview , Request $request): Response
    {
               $donnees = json_decode($request->getContent());

               if(
                   isset($donnees->start) && !empty($donnees->start) 
               ){
               
                   $code = 200;
                   if(!$interview){
                       $interview = new Interview;
       
                       $code = 201;
                   }
                   $interview->setDateTemps(new DateTimeInterface($donnees->start));   
                   $em = $this->getDoctrine()->getManager();
                   $em->persist($interview);
                   $em->flush();
                   return new Response('Ok', $code);
               }else{
                   return new Response('Données incomplètes', 404);
               }
               return $this->render('api/index.html.twig', [
                'controller_name' => 'ApiController',
            ]);
    
     }
}
