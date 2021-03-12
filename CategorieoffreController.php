<?php

namespace App\Controller;

use App\Entity\Categorieoffre;
use App\Form\CategorieoffreType;
use App\Repository\CategorieoffreRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/Categorieoffre")
 */
class CategorieoffreController extends AbstractController
{
    /**
     * @Route("/", name="Categorieoffre_index", methods={"GET"})
     */
    public function index(CategorieoffreRepository $CategorieoffreRepository): Response
    {
        return $this->render('admin/Categorieoffre/index.html.twig', [
            'Categorieoffres' => $CategorieoffreRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="Categorieoffre_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $Categorieoffre = new Categorieoffre();
        $form = $this->createForm(CategorieoffreType::class, $Categorieoffre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $uploadedFile = $form['logo']->getData();
            $filename = md5(uniqid()).'.'.$uploadedFile->guessExtension();
            $uploadedFile->move($this->getParameter('upload_directory'),$filename);
            $Categorieoffre->setLogo($filename);
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($Categorieoffre);
            $entityManager->flush();

            return $this->redirectToRoute('Categorieoffre_index');
        }

        return $this->render('/admin/Categorieoffre/new.html.twig', [
            'Categorieoffre' => $Categorieoffre,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="Categorieoffre_show", methods={"GET"})
     */
    public function show(Categorieoffre $Categorieoffre): Response
    {
        return $this->render('Categorieoffre/show.html.twig', [
            'Categorieoffre' => $Categorieoffre,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="Categorieoffre_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Categorieoffre $Categorieoffre): Response
    {
        $form = $this->createForm(CategorieoffreType::class, $Categorieoffre);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('Categorieoffre_index');
        }

        return $this->render('/admin/Categorieoffre/edit.html.twig', [
            'Categorieoffre' => $Categorieoffre,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="Categorieoffre_delete", methods={"DELETE"})
     */
    public function delete(Request $request, Categorieoffre $Categorieoffre): Response
    {
        if ($this->isCsrfTokenValid('delete'.$Categorieoffre->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($Categorieoffre);
            $entityManager->flush();
        }

        return $this->redirectToRoute('admin/Categorieoffre_index');
    }

}
