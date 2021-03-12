<?php

namespace App\Controller;

use App\Entity\Formation;
use App\Entity\User;
use App\Form\FormationType;
use App\Repository\CategorieRepository;
use App\Repository\FormationRepository;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class AdminFormationController extends AbstractController
{
    /**
     * @return Response
     * @Route("/admin/add_form",name="add_form")
     */
    public function addform ( Request $request, EntityManagerInterface $em , UserRepository $user_rep)
    {
    
        $formation=new Formation();
        $formation->setStatus("0");
        $formation->addIdUser($this->getUser());

        $form= $this->createForm(FormationType::class,$formation);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em->persist($formation);
            $em->flush();
            return $this->redirectToRoute("template");
        }
        return $this->render('admin/template/addform.html.twig',[
            'formation'=>$formation,
            'form'=>$form->createView(),
        ]);
    }

    /**
     * @return Response
     * @Route("/admin/forma_aff",name="forma_aff")
     */
    public function forma_aff(FormationRepository $repository,UserRepository  $repository2): Response
    {
        $formations=$repository->findAll();
        $users=$repository->findAll();
        return $this->render('admin/template/forma_aff.html.twig',[
            'formations'=>$formations,
            'users'=>$users

        ]);
    }

    /**
     * @return Response
     * @Route("/admin/desc_aff/{id}",name="desactive_form" )
     */
    public function desactiverforma($id, FormationRepository $repository)
    {
        $formation =$repository->find($id);
        $formation->setStatus("1");
        $em=$this->getDoctrine()->getManager();
        $em->persist($formation);
        $em->flush();
        return $this->redirectToRoute('forma_aff');
    }
    /**
     * @return Response
     * @Route("/admin/act_aff/{id}",name="active_form" )
     */
    public function activerforma($id, FormationRepository $repository)
    {
        $formation =$repository->find($id);
        $formation->setStatus("0");
        $em=$this->getDoctrine()->getManager();
        $em->persist($formation);
        $em->flush();
        return $this->redirectToRoute('forma_aff');
    }
    /**

     * @Route("/admin/formation/modif/{id}", name="admin_formation_modification", methods="GET|POST")
     */
    public function modificationform(Formation $formation, Request $request,EntityManagerInterface $em,UserRepository $user_rep)
    {
        $form= $this->createForm(FormationType::class,$formation);

        $user = $user_rep->findOneBy(['id'=> '3']);
        $form->handleRequest($request);
        $formation->setStatus("0");
        $formation->addIdUser($user);
        if($form->isSubmitted() && $form->isValid()){
            $em->persist($formation);
            $em->flush();
            $this->addFlash("success","La modification a été éffectuée");
            return $this->redirectToRoute("forma_aff");
        }
        return $this->render('admin/template/modificationformation.html.twig',[
            "formation"=>$formation,
            "form"=>$form->createView()

        ]);
    }


    /**
     * @return Response
     * @Route("/listeformationcat/{id}",name="listeformationcat")
     */
    function listFormationByCat(CategorieRepository $repcat ,FormationRepository $repform ,$id )
    {
        $categorie=$repcat->find($id);
        $formation=$repform->listFormationByCat($categorie->getId());
        return $this->render('admin/template/listeformationcat.html.twig',[
            'c'=>$categorie,
            'formations'=>$formation
        ]);

    }


    /**
     * @Route("/admin/formation/supp/{id}", name="admin_formation_suppression")
     */
    public function supprimerforma($id,FormationRepository $repository)
    {
            $formation=$repository->find($id);
            $em=$this->getDoctrine()->getManager();
            $em->remove($formation);
            $em->flush();
        return $this->redirectToRoute("forma_aff");


    }

}
