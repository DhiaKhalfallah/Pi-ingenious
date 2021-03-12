<?php

namespace App\Controller;

use App\Entity\Candidature;
use App\Entity\Interview;
use App\Entity\Offre;
use App\Form\CandidatureType;
use App\Form\InterviewType;
use App\Repository\CandidateRepository;
use App\Repository\CandidatureRepository;
use App\Repository\OffreRepository;
use Doctrine\ORM\EntityManager;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\IsGranted;
use Doctrine\ORM\EntityManagerInterface;

/**
 * @Route("/candidature")
 */
class CandidatureController extends AbstractController
{
 

    /**
     * @Route("/{id}/new/", name="candidature_post", methods={"GET","POST"})
     * @isGranted("ROLE_CANDIDATE")
     * 
     */
    public function new(Request $request , $id , OffreRepository $offreRepository): Response
    {
        $candidature = new Candidature();
        $candidature ->setCandidateId($this->getUser()) ; 
        $offre = new Offre() ; 
        $offre = $offreRepository->findOneBy(['id'=>$id]); 
        $candidature ->setOffreId($offre); 
        $candidature ->setEtat('en cours') ; 
        $candidature ->setDatePostuler(new \DateTime('now'));
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($candidature);
        $entityManager->flush();

        return $this->redirectToRoute('offre_index');
    
    }

      /**
     * @Route("/{id}/candidature/", name="candidature_postuler", methods={"GET","POST"})
     * @isGranted("ROLE_ENTEPRISE")
     * 
     */
    public function AfficherCandidatsPostuler(Request $request , $id , CandidatureRepository $candidatureRepository): Response
    {
        return $this->render('candidature/candidatpostuler.html.twig', [
          'candidatures' => $candidatureRepository->findBy(['offre_id'=>$id]),
        ]);
    }

          /**
     * @Route("/dhasbard", name="template")
     */
    public function indexb(): Response
    {
        return $this->render('backend/dashboard-1.html.twig', [
            'controller_name' => 'TemplateController',
        ]);
    }
    /**
     * @Route("/moncandidatures", name="mon_candidature")
     * @isGranted("ROLE_CANDIDATE")
     * 
     */
    public function AfiicherMonCandidature(Request $request  , CandidatureRepository $candidatureRepository): Response
    {
        return $this->render('offrefront/moncandidature.html.twig', [
          'candidatures' => $candidatureRepository->findBy(['candidate_id'=>$this->getUser()]),

        ]);
    }
    
    /**
     * @Route("/{id}/candidatureinterview/", name="candidature_interview", methods={"GET","POST"})
     * @isGranted("ROLE_ENTEPRISE")
     * 
     */
    public function PickerInterview(Request $request , $id ,CandidatureRepository $candidatureRepository ,  EntityManagerInterface $entitymanager): Response
    {
        $candidature = new Candidature() ;
        $candidature = $candidatureRepository->findOneBy(['id'=>$id]) ; 

        $interview= new Interview() ;
        $form = $this->createForm(InterviewType::class, $interview);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
            $interview->setEnteprise($this->getUser());
            $interview->setCand($candidature); 
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($interview);
            $entitymanager->flush();
            return $this->redirectToRoute('acceuil');
        }
        return $this->render('candidature/interviewform.html.twig',
            array('form'=> $form->createView())

        );
    
    }

    /**
     * @Route("/{id}/candidatureinterview/edit", name="editer_interview", methods={"GET","POST"})
     * @isGranted("ROLE_ENTEPRISE")
     * 
     */
    public function EditerInterview(Request $request , Interview $interview  ,CandidatureRepository $candidatureRepository ,  EntityManagerInterface $entitymanager): Response
    {
        $candidature = $interview->getCand(); 
        
        $form = $this->createForm(InterviewType::class, $interview);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid())
        {
            $interview->setEnteprise($this->getUser());
            $interview->setCand($candidature); 
            $entitymanager = $this->getDoctrine()->getManager();
            $entitymanager->persist($interview);
            $entitymanager->flush();
            return $this->redirectToRoute('offre_enteprise');
        }
        return $this->render('candidature/interviewform.html.twig',
            array('form'=> $form->createView() , 'interview' =>$interview)

        );
        
    
    }
     /**
     * @Route("/{id}", name="delete_interview", methods={"DELETE"})
     * @isGranted("ROLE_ENTEPRISE")
     */
    public function delete(Request $request, Interview $interview): Response
    {
        if ($this->isCsrfTokenValid('delete'.$interview->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($interview);
            $entityManager->flush();
        }

        return $this->redirectToRoute('offre_enteprise');
    }

 

}